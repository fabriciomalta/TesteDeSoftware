package exercicio07_18;

import static org.junit.Assert.*;

import org.junit.Test;

import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ProcessOrderUC_test {

    @Test
    public void testProcessOrderWithValidData() {
        // Arrange
        Order order = new Order(123, "test@example.com", "Test Order", "123 Main St");
        Validator validator = Mockito.mock(Validator.class);
        Mockito.when(validator.validateBasicData(order)).thenReturn(new ArrayList<>());
        Repository repo = Mockito.mock(Repository.class);
        Mockito.when(repo.orderProduct(Mockito.anyInt())).thenReturn(true);
        TransportService service = Mockito.mock(TransportService.class);
        Mockito.when(service.isDown()).thenReturn(false);
        EmailSender emailSender = Mockito.mock(EmailSender.class);
        Mockito.when(emailSender.isOffline()).thenReturn(false);
        Mockito.when(emailSender.sendEmail(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(1);
        ProcessOrderUC processOrderUC = new ProcessOrderUC(validator, repo);
        processOrderUC.setService(service);
        processOrderUC.setEmailSender(emailSender);

        // Act
        int[] result = processOrderUC.process(order);

        // Assert
        assertNotNull(result);
        assertEquals(4, result.length);
        assertEquals(1, result[0]); // transportId
        assertEquals(1, result[1]); // emailId
        assertEquals(1, result[2]); // orderedProds
        assertEquals(0, result[3]); // unorderedProds
    }

    @Test
    public void testProcessOrderWithValidationErrors() {
        // Arrange
        Order order = new Order(123, "test@example.com", "Test Order", "123 Main St");
        List<String> errors = new ArrayList<>();
        errors.add("Invalid email");
        Validator validator = Mockito.mock(Validator.class);
        Mockito.when(validator.validateBasicData(order)).thenReturn(errors);
        Repository repo = Mockito.mock(Repository.class);
        ProcessOrderUC processOrderUC = new ProcessOrderUC(validator, repo);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> processOrderUC.process(order));
    }

    @Test
    public void testProcessOrderWithServiceOffline() {
        // Arrange
        Order order = new Order(123, "test@example.com", "Test Order", "123 Main St");
        Validator validator = Mockito.mock(Validator.class);
        Mockito.when(validator.validateBasicData(order)).thenReturn(new ArrayList<>());
        Repository repo = Mockito.mock(Repository.class);
        TransportService service = Mockito.mock(TransportService.class);
        Mockito.when(service.isDown()).thenReturn(true);
        EmailSender emailSender = Mockito.mock(EmailSender.class);
        ProcessOrderUC processOrderUC = new ProcessOrderUC(validator, repo);
        processOrderUC.setService(service);
        processOrderUC.setEmailSender(emailSender);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> processOrderUC.process(order));
    }

    @Test
    public void testProcessOrderWithEmailSenderOffline() {
        // Arrange
        Order order = new Order(123, "test@example.com", "Test Order", "123 Main St");
        Validator validator = Mockito.mock(Validator.class);
        Mockito.when(validator.validateBasicData(order)).thenReturn(new ArrayList<>());
        Repository repo = Mockito.mock(Repository.class);
        TransportService service = Mockito.mock(TransportService.class);
        Mockito.when(service.isDown()).thenReturn(false);
        EmailSender emailSender = Mockito.mock(EmailSender.class);
        Mockito.when(emailSender.isOffline()).thenReturn(true);
        ProcessOrderUC processOrderUC = new ProcessOrderUC(validator, repo);
        processOrderUC.setService(service);
        processOrderUC.setEmailSender(emailSender);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> processOrderUC.process(order));
    }
}

