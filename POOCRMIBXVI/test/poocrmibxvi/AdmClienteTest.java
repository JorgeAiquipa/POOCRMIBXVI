/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poocrmibxvi;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author jaiquipa
 */
public class AdmClienteTest {
    
    public AdmClienteTest() {
    }

    @Test
    public void administradorDebeRegistrarCliente(){
        // Arrange
        String[] dnis = {"23272090", "23259395"};
        String[] apellidosPaterno = {"Contreras", "Bravo"};
        String[] apellidosMaterno = {"Chávez", "Mejía"};
        String[] nombres = {"Estanislao", "Francisco"};
        String[] emails = {"econtreras@tss.com.pe", "bbravo@upc.edu.pe"};
        String[] telefonos = {"2323456", "4405010"};               
        String[] celulares = {"992778439", "994405010"};               
        String[] fechasContacto = {"31-Mar-2012", "14-Abr-2011"};               

        
        ClienteManager admin = new ClienteManager();
        // Act
        int i;
        for(i = 0; i<dnis.length; i++)
            try {
            admin.altaClientes(dnis[i], 
                            apellidosPaterno[i],
                            apellidosMaterno[i],
                            nombres[i],
                            emails[i],
                            telefonos[i],
                            celulares[i],
                            fechasContacto[i]);
        } catch (BusinessException ex) {
            Logger.getLogger(AdmClienteTest.class.getName()).log(Level.SEVERE, null, ex);
        }                    
        // Assert
        int cantidadClientesEsperada = dnis.length;
        int cantidadClientesRetornada = admin.getCantidadClientes();
        assertEquals(cantidadClientesEsperada, cantidadClientesRetornada);
        for (i=0; i<dnis.length; i++){
            Cliente clienteBuscado = admin.buscar(dnis[i]); 
            assertNotNull(clienteBuscado);
        }
    }
    
}
