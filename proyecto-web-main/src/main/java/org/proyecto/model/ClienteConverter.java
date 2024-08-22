/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.proyecto.model;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.proyecto.managedbeans.FacturaMB;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        FacturaMB bean = context.getApplication().evaluateExpressionGet(context, "#{facturaMB}", FacturaMB.class);
        return bean.getClientePorId(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Cliente) {
            return String.valueOf(((Cliente) value).getIdCliente());
        }
        return "";
    }
}