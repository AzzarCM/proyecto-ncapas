$("select#departamentoSelect").change(function() {
    let departamentoValue = $("#departamentoSelect").val();
    $.ajax({
        url: '/municipios?id=' + departamentoValue,
        method: 'GET',
    }).done(
        function (municipios) {
            let stateSelect = $('#municipioSelect');
            let ceSelect = $('#institucionSelect')
            ceSelect.find('option').remove()
            ceSelect.append("<option value=0 > - Seleccione una institucion - </option>")

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

$("select#municipioSelect").change(function() {
    let munValue = $("#municipioSelect").val();
    console.log("MUN-CAMBIO")
    $.ajax({
        url: '/instituciones?id=' + munValue,
        method: 'GET',
    }).done(
        function (institucion) {
            let stateSelect = $('#institucionSelect');
            stateSelect.find('option').remove();
            stateSelect.append("<option value=0 > - Seleccione una institucion - </option>")
            let municipioValue = $("#institucionSelect").val()
            for (let i = 0; i < institucion.length; i++) {
                if( municipioValue != institucion[i].idCentroEscolar){
                    stateSelect.append("<option value=" + institucion[i].idCentroEscolar + " >" + institucion[i].nombre + "</option>")
                }
            }
        }).fail(
        function() {
            alert('error inesperado');
        }
    )
})