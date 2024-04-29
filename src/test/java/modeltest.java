import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CalcModel;
import model.Operation;

class modeltest
{

	
	DoubleProperty num1 = new SimpleDoubleProperty();
	DoubleProperty num2 = new SimpleDoubleProperty();
	DoubleProperty resultmodel = new SimpleDoubleProperty();
	
	
	ObservableList<Operation> operations = FXCollections.observableArrayList();
	CalcModel tm;//testmodel
	@BeforeEach
	void setUp() throws Exception
	{
		num1 = new SimpleDoubleProperty(40.0);
		num2 = new SimpleDoubleProperty(4.0);

		tm = new CalcModel();
		tm.setNum1(num1);
		tm.setNum2(num2);
	}
	

	@Test
	void test()
	{
		tm.add();
		DoubleProperty numresult = new SimpleDoubleProperty(44.0);
		Operation ad = new Operation(num1.doubleValue()," + ",num2.doubleValue(),tm.getResult().doubleValue());
		operations.add(ad);
		assertEquals(numresult.doubleValue(),tm.getResult().doubleValue());
		tm.divide();;
		numresult = new SimpleDoubleProperty(10.0);
		Operation divi = new Operation(num1.doubleValue()," / ",num2.doubleValue(),tm.getResult().doubleValue());
		operations.add(divi);
		assertEquals(numresult.doubleValue(),tm.getResult().doubleValue());
		tm.multiply();
		numresult = new SimpleDoubleProperty(160.0);
		Operation mult = new Operation(num1.doubleValue()," * ",num2.doubleValue(),tm.getResult().doubleValue());
		operations.add(mult);
		assertEquals(numresult.doubleValue(),tm.getResult().doubleValue());
		tm.subtract();
		numresult = new SimpleDoubleProperty(36.0);
		Operation sub = new Operation(num1.doubleValue()," - ",num2.doubleValue(),tm.getResult().doubleValue());
		operations.add(sub);
		assertEquals(numresult.doubleValue(),tm.getResult().doubleValue());
		assertEquals(operations.toString(),tm.getOperations().toString());
		assertEquals(num1,tm.getNum1());
		assertEquals(num2,tm.getNum2());
		tm.setResult(numresult);
		assertEquals(numresult,tm.getResult());
		operations.clear();
		tm.setOperations(operations);
		assertEquals(operations.toString(),tm.getOperations().toString());
	}

}
