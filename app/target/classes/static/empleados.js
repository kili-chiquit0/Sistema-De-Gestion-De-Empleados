document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('empleadoForm');
    const tabla = document.getElementById('tablaEmpleados');
    
    form.addEventListener('submit', function(e) {
        e.preventDefault();
        
        const empleado = {
            nombre: document.getElementById('nombre').value,
            apellido: document.getElementById('apellido').value,
            email: document.getElementById('email').value,
            departamento: document.getElementById('departamento').value,
            salario: document.getElementById('salario').value,
            fecha_contratacion: document.getElementById('fecha_contratacion').value,
            activo: document.getElementById('activo').checked
        };
        
        agregarEmpleadoTabla(empleado);
        form.reset();
    });
    
    function agregarEmpleadoTabla(empleado) {
        const row = tabla.insertRow();
        
        row.innerHTML = `
            <td>${empleado.nombre}</td>
            <td>${empleado.apellido}</td>
            <td>${empleado.email}</td>
            <td>${empleado.departamento}</td>
            <td>$${empleado.salario}</td>
            <td>${empleado.fecha_contratacion}</td>
            <td>${empleado.activo ? 'Sí' : 'No'}</td>
            <td>
                <button onclick="editarEmpleado(this)">Editar</button>
                <button onclick="eliminarEmpleado(this)">Eliminar</button>
            </td>
        `;
    }
    
    window.editarEmpleado = function(button) {
        alert('Función editar - por implementar');
    };
    
    window.eliminarEmpleado = function(button) {
        if (confirm('¿Estás seguro de eliminar este empleado?')) {
            button.closest('tr').remove();
        }
    };
});