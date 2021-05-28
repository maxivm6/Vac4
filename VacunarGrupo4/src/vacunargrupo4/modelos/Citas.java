package vacunargrupo4.modelos;

import java.sql.Time;
import java.util.Date;

public class Citas {

    private Vacuna vacuna;
    private CtroVacunacion centro;
    private Persona persona;
    private String motivo;
    private boolean estado=true;
    private Date fecha;
    private Time hora;

    public Citas(Vacuna vacuna, CtroVacunacion centro, Persona persona, String motivo, Date fecha, Time hora) {
        this.vacuna = vacuna;
        this.centro = centro;
        this.persona = persona;
        this.motivo = motivo;
        this.fecha = fecha;
        this.hora = hora;
    }

    

    public Citas() {
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    public CtroVacunacion getCentro() {
        return centro;
    }

    public void setCentro(CtroVacunacion centro) {
        this.centro = centro;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
    
}