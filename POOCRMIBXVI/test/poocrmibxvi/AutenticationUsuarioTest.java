/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poocrmibxvi;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge Aiquipa
 */
public class AutenticationUsuarioTest {
    
    public AutenticationUsuarioTest() {
    }
    

    @Test
    public void usuarioDebeCrearse() {
        String[] dnis = {"23272090", "23259395"};
        String[] apellidosPaterno = {"Contreras", "Bravo"};
        String[] apellidosMaterno = {"Chávez", "Mejía"};
        String[] nombres = {"Estanislao", "Francisco"};
        String[] usuarios = {"jaiquipa","cbenavides"};
        String[] emails = {"econtreras@tss.com.pe", "bbravo@upc.edu.pe"};
        String[] fechasIngreso = {"07.Dic.2012","07.Dic.2012"};
        String[] cargos = {"JEFE DE PROGRAMADORES","Asistente "};
        String[] contrasenhas = {"123874","878763"};
        String[] creadoPor= {"Adminis","Adminis"};
        String[] creadoFecha = {"07.Dic.2012","07.Dic.2012"};
        UsuarioManager admin = new UsuarioManager();
        // Act
        int i;
        for(i = 0; i<dnis.length; i++)
            try {
            admin.altaUsuario(dnis[i],                   
                            nombres[i],
                            apellidosPaterno[i],
                            apellidosMaterno[i],
                            usuarios[i],
                            emails[i],
                            fechasIngreso[i],
                            cargos[i],
                            contrasenhas[i],
                            creadoPor[i],
                            creadoFecha[i]);
        } catch (BusinessException ex) {
            Logger.getLogger(AutenticationUsuarioTest.class.getName()).log(Level.SEVERE, null, ex);
        }                    
        // Assert
        int cantidadUsuariosEsperada = dnis.length;
        int cantidadUsuariosRetornada = admin.getCantidadUsuarios();
        assertEquals(cantidadUsuariosEsperada, cantidadUsuariosRetornada);
       
    }

}
