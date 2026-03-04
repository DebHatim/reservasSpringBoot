// src/main/resources/static/js/scripthotel.js
document.addEventListener('DOMContentLoaded', function() {
    const fechaInicio = document.getElementById('fechaInicio');
    const fechaFin = document.getElementById('fechaFin');

    function actualizarFechas() {
        document.querySelectorAll('.fechaInicioHidden').forEach(el => el.value = fechaInicio.value);
        document.querySelectorAll('.fechaFinHidden').forEach(el => el.value = fechaFin.value);
    }

    if (fechaInicio && fechaFin) {
        fechaInicio.addEventListener('change', actualizarFechas);
        fechaFin.addEventListener('change', actualizarFechas);
    }

    // Validación antes de enviar
    document.querySelectorAll('.reserva-form').forEach(form => {
        form.addEventListener('submit', (e) => {
            if (!fechaInicio.value || !fechaFin.value) {
                e.preventDefault();
                alert('Por favor, selecciona primero las fechas de llegada y salida arriba.');
            }
        });
    });
});