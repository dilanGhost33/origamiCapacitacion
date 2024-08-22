/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.proyecto.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.proyecto.config.Constantes;
import org.proyecto.model.Cliente;
import org.proyecto.model.DetalleFactura;
import org.proyecto.model.DetalleFacturaDTO;
import org.proyecto.model.Factura;
import org.proyecto.model.FacturaDTO;
import org.proyecto.model.Producto;
import org.proyecto.services.intefaces.AppServices;

/**
 *
 * @author PC
 */
@Named
@ViewScoped
public class FacturaMB implements Serializable{
    
    @Inject
    private AppServices appServices;
    
    private List<Factura> facturas;
    private List<Producto> productos;
    private List<Producto> productosDisponibles;
    private List<DetalleFactura> detalles;
    private List<Cliente> clientes;
    private Producto productoSeleccionado;
    private int cantidadSeleccionada;
    private double total;
   
    private DetalleFactura detalle;
    private Producto producto;
    private Factura factura;
    private Cliente cliente;
    private Cliente clienteSeleccionado;
    @PostConstruct
    public void init(){
        System.out.println("init");
        cargarDatos();
        System.out.println("init "+factura);
        factura.setCliente(new Cliente());
        System.out.println("init "+factura.getCliente());
        factura.setFecha(new Date());


    }

    private void cargarDatos() {
        total=0;
        factura = new Factura();
        producto = new Producto();
        cliente = new Cliente();
        detalle= new DetalleFactura();
        detalles = new ArrayList<>();
        facturas = appServices.methodListGET(Constantes.appUrl+"facturas", Factura[].class);
        productos = appServices.methodListGET(Constantes.appUrl+"productos", Producto[].class);
        productosDisponibles=productos;
        clientes = appServices.methodListGET(Constantes.appUrl+"clientes", Cliente[].class);
    }
    public void guardarFactura() throws Exception {
         try {
            validarFactura();
            FacturaDTO facturaDTO = crearFacturaDTO();
            Factura facturaGuardada = enviarFacturaAlServidor(facturaDTO);
            procesarRespuestaDelServidor(facturaGuardada);
        } catch (Exception e) {
            manejarError(e);
        }
    
    }
        private void validarFactura() throws Exception {
        if (detalles == null || detalles.isEmpty()) {
            throw new Exception("No hay detalles en la factura");
        }
        if (cliente == null) {
            throw new Exception("No se ha seleccionado un cliente");
        }
    }

    private FacturaDTO crearFacturaDTO() {
        FacturaDTO facturaDTO = new FacturaDTO();
        facturaDTO.setIdCliente(cliente.getIdCliente());
        facturaDTO.setFecha(new Date());
        facturaDTO.setTotal(total);
        facturaDTO.setDetalles(crearDetallesDTO());
        return facturaDTO;
    }

    private List<DetalleFacturaDTO> crearDetallesDTO() {
        return detalles.stream().map(detalle -> {
            DetalleFacturaDTO detalleDTO = new DetalleFacturaDTO();
            detalleDTO.setIdProducto(detalle.getProducto().getIdProducto());
            detalleDTO.setCantidad(detalle.getCantidad());
            detalleDTO.setPrecioUnitario(detalle.getPrecioUnitario());
            detalleDTO.setSubtotal(detalle.getSubtotal());
            return detalleDTO;
        }).collect(Collectors.toList());
    }

    private Factura enviarFacturaAlServidor(FacturaDTO facturaDTO) throws Exception {
        System.out.println("FacturaDTO a guardar: " + facturaDTO);
        return (Factura) appServices.methodPOST(facturaDTO, Constantes.appUrl + "guardarfactura", Factura.class);
    }

    private void procesarRespuestaDelServidor(Factura facturaGuardada) throws Exception {
        if (facturaGuardada != null) {
            System.out.println("Factura guardada: " + facturaGuardada);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Factura guardada correctamente"));
            cargarDatos();
        } else {
            throw new Exception("Error al guardar la factura");
        }
    }

    private void manejarError(Exception e) {
        System.out.println("Error al guardar la factura: " + e.getMessage());
        e.printStackTrace();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
    }

    public void agregarDetalle() {
        System.out.println("i "+productoSeleccionado);
        if (productoSeleccionado != null && cantidadSeleccionada > 0) {
            DetalleFactura detalle = new DetalleFactura();
            detalle.setProducto(productoSeleccionado);
            detalle.setCantidad(cantidadSeleccionada);
            detalle.setPrecioUnitario(productoSeleccionado.getPrecio());
            detalle.setSubtotal(cantidadSeleccionada * productoSeleccionado.getPrecio());
            total+=detalle.getSubtotal();
            if (detalles == null) {
                detalles = new ArrayList<>();
            }
            detalles.add(detalle);

            System.out.println("Detalle agregado: " + detalle);
            System.out.println("Total detalles: " + detalles.size());
            System.out.println("agregados detalles: " + detalles.toString());
            // Reiniciar selecciones
            productoSeleccionado = null;
            cantidadSeleccionada = 0;
        }
        FacesContext.getCurrentInstance().getViewRoot().getViewMap().put("facturaMB", this);
    }

    public Producto getProductoPorId(Long id) {
        return productosDisponibles.stream()
                .filter(p -> p.getIdProducto().equals(id))
                .findFirst()
                .orElse(null);
    }
    public void actualizarInfoCliente() {
        if (factura.getCliente() != null) {
            cliente = factura.getCliente();
            System.out.println("slect "+ cliente.getNombre());
            System.out.println("Cliente seleccionado: " + factura.getCliente().getNombre());
        } else {
            System.out.println("No se ha seleccionado ningun cliente.");
        }
    }

    public Cliente getClientePorId(Long id) {
        return clientes.stream()
                .filter(c -> c.getIdCliente().equals(id))
                .findFirst()
                .orElse(null);
    }
    public void guardarProducto(){
        System.out.println(""+producto);
        Producto p = (Producto)appServices.methodPOST(producto, 
                               Constantes.appUrl+"guardarproducto", Producto.class);
        System.out.println("Respuesta guardada: " + p.toString());
        cargarProductos();

    }
    public void editarProducto(Producto p){
        producto = p;
    }
    public void eliminarProducto(Producto p){
        String l = (String)appServices.methodDELETE(
                               Constantes.appUrl+"borrarproducto/"+p.getIdProducto(), Producto.class);
        System.out.println("l");
        cargarProductos();
    }
    private void cargarProductos() {
        producto = new Producto();
        productos = appServices.methodListGET(Constantes.appUrl+"productos", Producto[].class);
        System.out.println(""+productos.size());
    }
    //clientes
    public void guardarCliente(){
        System.out.println(""+cliente);
        Cliente p = (Cliente)appServices.methodPOST(cliente, 
                               Constantes.appUrl+"guardarcliente", Cliente.class);
        System.out.println("Respuesta guardada: " + p.toString());
        cargarClientes();

    }
    public void editarCliente(Cliente p){
        cliente = p;
    }
    public void eliminarCliente(Cliente p){
        String l = (String)appServices.methodDELETE(
                               Constantes.appUrl+"borrarcliente/"+p.getIdCliente(), Cliente.class);
        System.out.println("l");
        cargarClientes();
    }
    private void cargarClientes() {
        cliente = new Cliente();
        clientes = appServices.methodListGET(Constantes.appUrl+"clientes", Cliente[].class);
        System.out.println(""+clientes.size());
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    



    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public DetalleFactura getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleFactura detalle) {
        this.detalle = detalle;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getClienteSeleccionado() {
        return clienteSeleccionado;
    }

    public void setClienteSeleccionado(Cliente clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
    }

    public Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(Producto productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public int getCantidadSeleccionada() {
        return cantidadSeleccionada;
    }

    public void setCantidadSeleccionada(int cantidadSeleccionada) {
        this.cantidadSeleccionada = cantidadSeleccionada;
    }

    public List<Producto> getProductosDisponibles() {
        return productosDisponibles;
    }

    public void setProductosDisponibles(List<Producto> productosDisponibles) {
        this.productosDisponibles = productosDisponibles;
    }

    
}
