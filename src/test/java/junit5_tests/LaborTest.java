package junit5_tests;

import com.spring.mvc.controller.MVC_Controller;
import com.spring.mvc.dao.LaborDAOImpl;
import com.spring.mvc.entity.Labor;
import com.spring.mvc.service.ServiceDaoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;
import static org.assertj.core.api.Assertions.*;

public class LaborTest {
    private ServiceDaoImpl serviceDaoImpl;
    private LaborDAOImpl laborDAOImpl;

//    @Mock
//    private LaborDAO laborDAO;
//
//    @InjectMocks
//    private ServiceDaoImpl serviceDaoImpl;

    @BeforeEach
    void preparationsForTest(){
        System.out.println("BeforeEach - Preparations for Each Test");
        serviceDaoImpl = Mockito.mock(ServiceDaoImpl.class);
        laborDAOImpl = Mockito.mock(LaborDAOImpl.class);
    }

    @Test
    void saveUpdateLaborShouldThrowExceptionTest() {
        MVC_Controller testController = new MVC_Controller();
        Labor labor = new Labor();
        Assertions.assertThrows(NullPointerException.class,() -> testController.saveUpdateLabor(labor, null));
    }

    @Test                                                       // further testing is through Mockito.mock and AssertJ
    void getAllLaborsDoesNotThrowAnExceptionTest(){
        Labor labor = new Labor();
        Assertions.assertDoesNotThrow(() -> laborDAOImpl.saveLabor(labor));
    }

    @Test
    void getAlllaborsShouldBeZeroSize(){
        assertThat(laborDAOImpl.getAllLabors()).hasSize(0);
    }

    @Test
    void shouldReturnLaborByIdTest(){
        Optional<Labor> maybeLabor = Optional.ofNullable(laborDAOImpl.getLaborById(1));
        assertThat(maybeLabor.isPresent());
    }
}