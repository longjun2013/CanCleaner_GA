package cancleaner.geneticalgorithms;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

public class FirstGenerationItemsCreatorTest {

    @Test
    public void should_create_200_items() {
        List<Item> items = new FirstGenerationItemsCreator().create();

        assertThat(items.size(), is(200));
    }

    @Test
    public void should_create_items_with_generation_id() {
        List<Item> items = new FirstGenerationItemsCreator().create();

        for (Item item : items) {
            assertThat(item.getGenerationId(), is(1));
        }
    }

    @Test
    public void should_create_items_with_gene() {
        List<Item> items = new FirstGenerationItemsCreator().create();

        for (Item item : items) {
            assertThat(item.getGene().length(), is(3 * 3 * 3 * 3 * 3));
        }
    }

    @Test
    public void should_create_items_with_gene_between_0_and_5() {
        List<Item> items = new FirstGenerationItemsCreator().create();

        for (Item item : items) {
            for (int i = 0; i < item.getGene().length(); i++) {
                assertThat(Integer.valueOf(String.valueOf(item.getGene().charAt(i))), greaterThanOrEqualTo(0));
                assertThat(Integer.valueOf(String.valueOf(item.getGene().charAt(i))), lessThanOrEqualTo(5));
            }
        }
    }
}
