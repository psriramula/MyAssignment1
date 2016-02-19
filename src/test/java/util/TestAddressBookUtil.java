package util;

import com.prasad.intervewPrep.model.AddressBook;
import com.prasad.intervewPrep.service.DataReadService;
import com.prasad.intervewPrep.util.AddressBookUtil;
import org.junit.Test;


/**
 * Created by prasadsriramula on 18/02/2016.
 */
public class TestAddressBookUtil {

    private DataReadService dataReadService = new DataReadService();



    @Test
    public void shouldReturnCountForMaleGender() {
        String aDataFile = "/AddressBook";
        AddressBook ad = dataReadService.readAddressBook(aDataFile);

        assert (AddressBookUtil.getGenderCount(ad, "Male")== 3);
    }

    @Test
    public void shouldReturnCountForFeMaleGender() {
        String aDataFile = "/AddressBook";
        AddressBook ad = dataReadService.readAddressBook(aDataFile);

        assert (AddressBookUtil.getGenderCount(ad, "Female")== 2);
    }

    @Test
    public void shouldReturnCountForInvalidGender() {
        String aDataFile = "/AddressBook";
        AddressBook ad = dataReadService.readAddressBook(aDataFile);

        assert (AddressBookUtil.getGenderCount(ad, "None") != 2);
    }


}
