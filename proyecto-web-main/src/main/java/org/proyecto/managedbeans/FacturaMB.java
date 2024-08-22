/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.proyecto.managedbeans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.proyecto.config.Constantes;
import org.proyecto.model.Cliente;
import org.proyecto.model.DetalleFactura;
import org.proyecto.model.Factura;
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
    private List<DetalleFactura> detalles;
    private List<Cliente> clientes;

    
    private DetalleFactura detalle;
    private Producto producto;
    private Factura factura;
    private Cliente cliente;
    
    @PostConstruct
    public void init(){
        System.out.println("init");
        cargarDatos();
    }

    private void cargarDatos() {
        factura = new Factura();
        producto = new Producto();
        cliente = new Cliente();
        detalle= new DetalleFactura();
        facturas = appServices.methodListGET(Constantes.appUrl+"facturas", Factura[].class);
        productos = appServices.methodListGET(Constantes.appUrl+"productos", Producto[].class);
        clientes = appServices.methodListGET(Constantes.appUrl+"clientes", Cliente[].class);
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

    
}
