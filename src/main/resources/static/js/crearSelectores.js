$("select#departamentoSelect").change(function() {
    let departamentoValue = $("#departamentoSelect").val();
    $.ajax({
        url: '/municipios?id=' + departamentoValue,
        method: 'GET',
    }).done(
        function (municipios) {
            let stateSelect = $('#municipioSelect');
            stateSelect.find('option').remove();
            stateSelect.append("<option value=0 > - Seleccione un municipio - </option>")
            let municipioValue = $("#municipioSelect").val()
            for (let i = 0; i < municipios.length; i++) {
                if( municipioValue != municipios[i].idMunicipio){
                    stateSelect.append("<option value=" + municipios[i].idMunicipio + " >" + municipios[i].nombre + "</option>")
                }
            }
        }).fail(
        function() {
            alert('error inesperado');
        }
    )
})