document.addEventListener('DOMContentLoaded', function() {
    cargarProductos();
    document.getElementById('btnAgregar').addEventListener('click', mostrarFormularioCrear);
});

function cargarProductos() {
    fetch('http://localhost:8080/api/productos/')
        .then(response => {
            if (!response.ok) {
                throw new Error('Error en la carga de productos: ' + response.statusText);
            }
            return response.json();
        })
        .then(data => mostrarProductos(data))
        .catch(error => console.error('Error al cargar los productos:', error));
}


function mostrarProductos(productos) {
    const contenedor = document.getElementById('productos');
    contenedor.innerHTML = '';
    if (Array.isArray(productos)) {
    productos.forEach(producto => {
        const div = document.createElement('div');
        div.className = 'producto';
        div.innerHTML = `
            <h3>${producto.nombre}</h3>
            <p>Precio: $${producto.precio}</p>
            <p>Cantidad: ${producto.cantidad}</p>
            <p>Categoría: ${producto.categoria}</p>
            <button class="btnEditar" onclick="mostrarFormularioEditar(${producto.id})">Editar</button>
            <button class="btnEliminar" onclick="eliminarProducto(${producto.id})">Eliminar</button>
        `;
        contenedor.appendChild(div);
    });
} else {
    console.error('Se esperaba un array de productos:', productos);
}
}

function mostrarFormularioCrear() {
    document.getElementById('productoId').value = '';
    document.getElementById('nombre').value = '';
    document.getElementById('precio').value = '';
    document.getElementById('cantidad').value = '';
    document.getElementById('categoria').value = '';
    document.getElementById('modalFormulario').style.display = 'block';
}

function mostrarFormularioEditar(id) {
    fetch(`http://localhost:8080/api/productos/${id}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById('productoId').value = data.id;
            document.getElementById('nombre').value = data.nombre;
            document.getElementById('precio').value = data.precio;
            document.getElementById('cantidad').value = data.cantidad;
            document.getElementById('categoria').value = data.categoria;
            document.getElementById('modalFormulario').style.display = 'block';
        })
        .catch(error => console.error('Error al cargar el producto:', error));
}

function cerrarFormulario() {
    document.getElementById('modalFormulario').style.display = 'none';
}

document.getElementById('formularioProducto').addEventListener('submit', function(e) {
    e.preventDefault();
    const productoId = document.getElementById('productoId').value;
    const productoData = {
        nombre: document.getElementById('nombre').value,
        precio: parseFloat(document.getElementById('precio').value),
        cantidad: parseInt(document.getElementById('cantidad').value, 10),
        categoria: document.getElementById('categoria').value
    };

    if (productoId) {
        actualizarProducto(productoId, productoData);
    } else {
        crearProducto(productoData);
    }
});

function crearProducto(producto) {
    fetch('http://localhost:8080/api/productos/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(producto),
    })
    .then(response => response.json())
    .then(data => {
        cerrarFormulario();
        cargarProductos();
    })
    .catch(error => console.error('Error al crear el producto:', error));
}

function actualizarProducto(id, producto) {
    fetch(`http://localhost:8080/api/productos/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(producto),
    })
    .then(response => response.json())
    .then(data => {
        cerrarFormulario();
        cargarProductos();
    })
    .catch(error => console.error('Error al actualizar el producto:', error));
}

function eliminarProducto(id) {
    if (!confirm('¿Está seguro de querer eliminar este producto?')) return;

    fetch(`http://localhost:8080/api/productos/${id}`, {
        method: 'DELETE',
    })
    .then(() => cargarProductos())
    .catch(error => console.error('Error al eliminar el producto:', error));
}
