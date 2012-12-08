package poocrmibxvi;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;
import static org.junit.Assert.*;

public class AdmProspectoTest {
    
    public AdmProspectoTest() {
    }
    
    @Test
    public void administradorDebeRegistrarProspecto(){
        // Arrange
        String[] dnis = {"23272090", "23259395"};
        String[] apellidosPaterno = {"Contreras", "Bravo"};
        String[] apellidosMaterno = {"Chávez", "Mejía"};
        String[] nombres = {"Estanislao", "Francisco"};
        String[] emails = {"econtreras@tss.com.pe", "bbravo@upc.edu.pe"};
        String[] telefonos = {"2323456", "4405010"};                            
        String[] fechasContacto = {"31-Mar-2012", "14-Abr-2011"};               

        
        ProspectoManager admin = new ProspectoManager();
        // Act
        int i;
        for(i = 0; i<dnis.length; i++)
            try {
            admin.altaProspectos(dnis[i], 
                            apellidosPaterno[i],
                            apellidosMaterno[i],
                            nombres[i],
                            emails[i],
                            telefonos[i],
                            fechasContacto[i]);
        } catch (BusinessException ex) {
            Logger.getLogger(AdmClienteTest.class.getName()).log(Level.SEVERE, null, ex);
        }                    
        // Assert
        int cantidadProspectosEsperada = dnis.length;
        int cantidadProspectosRetornada = admin.getCantidadProspectos();
        assertEquals(cantidadProspectosEsperada, cantidadProspectosRetornada);
        for (i=0; i<dnis.length; i++){
            Prospecto prospectoBuscado = admin.buscar(dnis[i]); 
            assertNotNull(prospectoBuscado);
        }
    }
}
