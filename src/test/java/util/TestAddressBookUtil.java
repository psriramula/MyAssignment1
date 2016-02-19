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


    @Test
    public void shouldReturnOldestContactFromAddressBook() {
        String aDataFile = "/AddressBook";
        AddressBook ad = dataReadService.readAddressBook(aDataFile);
        assert (AddressBookUtil.getOldestContact(ad).get().equals(ad.getContacts().get(4)));
    }

    @Test
    public void shouldReturnOldestContactFromAddressWithChangedDates() {
        String aDataFile = "/AddressBookOldestMan";
        AddressBook ad = dataReadService.readAddressBook(aDataFile);
        assert (AddressBookUtil.getOldestContact(ad).get().equals( ad.getContacts().get(1)));
    }

    @Test
    public void shoudGetContactByNameForExistingContactName() {
        String aDataFile = "/AddressBook";
        AddressBook ad = dataReadService.readAddressBook(aDataFile);
        assert (AddressBookUtil.getContactByName(ad, "Bill McKnight").isPresent());
    }


    @Test
    public void sholdGetPositiveNumberForAgeDifferenceForValidDOBs() {
        String aDataFile = "/AddressBook";
        AddressBook ad = dataReadService.readAddressBook(aDataFile);
        assert ( AddressBookUtil.getAgeDifferenceInDays(
                ad, "Paul Robinson", "Bill McKnight"
        ).get() == 2862);
    }





}
