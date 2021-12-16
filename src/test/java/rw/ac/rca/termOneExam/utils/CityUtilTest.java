package rw.ac.rca.termOneExam.utils;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class CityUtilTest {
List<String> mock=mock(List.class);
 @Test
    public void mocking(){
     ArrayList<String> arrayListMock=mock(ArrayList.class);
     System.out.println(arrayListMock.get(0));
     System.out.println(arrayListMock.size());

     arrayListMock.add("Test");
     arrayListMock.add("test2");
     System.out.println(arrayListMock.size());

     when(arrayListMock.size()).thenReturn(5);
     System.out.println(arrayListMock.size());
 }

    @Test
    public void spying() {

        //spying retains original behaviour of the code
        ArrayList<String> arrayListSpy =  spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0));//Test0
        System.out.println(arrayListSpy.size());//1

        arrayListSpy.add("Test");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size());//3

        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());//5

        arrayListSpy.add("Test3");
        System.out.println(arrayListSpy.size());//5

    }

    @Test
    public void verification(){
    String value=mock.get(0);
    String value2=mock.get(1);

    verify(mock).get(0);

    verify(mock,times(2)).get(anyInt());
    verify(mock,atLeast(1)).get(anyInt());
    verify(mock,atMost(2)).get(anyInt());
    verify(mock,never()).get(2);
    }
}
