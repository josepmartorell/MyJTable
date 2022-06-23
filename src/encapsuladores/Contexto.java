/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encapsuladores;

import java.util.Date;

/**
 *
 * @author jtech
 */
public class Contexto {
    
    private String identificadorUsuario;
    private Date fechaHora;
    private String ipCliente;

    public Contexto(String identificadorUsuario, String ipCliente) {
        this.identificadorUsuario = identificadorUsuario;
        this.ipCliente = ipCliente;
        fechaHora = new Date();
        
    }

    public String getIdentificadorUsuario() {
        return identificadorUsuario;
    }

    public void setIdentificadorUsuario(String identificadorUsuario) {
        this.identificadorUsuario = identificadorUsuario;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getIpCliente() {
        return ipCliente;
    }

    public void setIpCliente(String ipCliente) {
        this.ipCliente = ipCliente;
    }
    
    
    
   
    
}
