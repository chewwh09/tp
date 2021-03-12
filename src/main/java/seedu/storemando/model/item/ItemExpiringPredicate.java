package seedu.storemando.model.item;

import static java.time.temporal.ChronoUnit.DAYS;

import java.util.function.Predicate;
import java.time.LocalDate;

/**
 * Tests that a {@code Item}'s {@code expiry date} is within the stipulated days from today.
 */
public class ItemExpiringPredicate implements Predicate<Item> {
    private final Long numOfDays;

    public ItemExpiringPredicate(Long numOfDays) {
        this.numOfDays = numOfDays;
    }

    @Override
    public boolean test(Item item) {
        LocalDate itemExpiryDate = item.getExpiryDate().expiryDate;
        LocalDate today = LocalDate.now();
        Long daysDifference = DAYS.between(today, itemExpiryDate);
        return daysDifference <= numOfDays;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof ItemExpiringPredicate // instanceof handles nulls
            && numOfDays == ((ItemExpiringPredicate)other).numOfDays); // state check
    }
}
