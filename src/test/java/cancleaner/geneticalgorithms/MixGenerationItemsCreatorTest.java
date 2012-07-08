package cancleaner.geneticalgorithms;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class MixGenerationItemsCreatorTest {

    private MixGenerationItemsCreator mixGenerationItemsCreator;
    private ImmutableList<Item> items;
    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;
    private RandomGeneMixProvider mockRandomGeneMixProvider;

    @Before
    public void setUp() {
        mixGenerationItemsCreator = new MixGenerationItemsCreator();
        item1 = new Item(1);
        item2 = new Item(1);
        item3 = new Item(1);
        item4 = new Item(1);
        items = ImmutableList.of(item1, item2, item3, item4);

        mockRandomGeneMixProvider = mock(RandomGeneMixProvider.class);
        mixGenerationItemsCreator.setRandomGeneMixProvider(mockRandomGeneMixProvider);


    }

    @Test
    public void should_find_top_half_high_score_items() {
        item1.setScore(10);
        item2.setScore(5);
        item3.setScore(13);
        item4.setScore(9);
        assertThat(mixGenerationItemsCreator.getHalfTopItems(items).size(), is(2));
        assertThat(mixGenerationItemsCreator.getHalfTopItems(items), contains(item1, item3));
    }

    @Test
    public void should_generate_same_count_of_new_items_from_high_score_parents() {
        item1.setGene("12345");
        item2.setGene("12345");
        item3.setGene("12345");
        item4.setGene("12345");
        List<Item> newItems = mixGenerationItemsCreator.create(items);

        assertThat(newItems.size(), is(items.size()));
    }

    @Test
    public void should_generate_two_new_items_with_extended_gene_from_parents() {
        given(mockRandomGeneMixProvider.getGeneBreakPosition()).willReturn(2);
        item1.setGene("12345");
        item3.setGene("56789");
        List<Item> youthItems = mixGenerationItemsCreator.mix(item1, item3);

        assertThat(youthItems.size(), is(2));
        assertThat(youthItems.get(0).getGene(), is("12789"));
        assertThat(youthItems.get(1).getGene(), is("34556"));
    }

    @Test
    public void should_generate_two_new_items_with_generation_auto_increase_from_parents() {
        item1.setGene("12345");
        item3.setGene("56789");
        List<Item> youthItems = mixGenerationItemsCreator.mix(item1, item3);

        assertThat(youthItems.size(), is(2));
        assertThat(youthItems.get(0).getGenerationId(), is(2));
        assertThat(youthItems.get(1).getGenerationId(), is(2));
    }

    @Test
    public void should_change_to_item_gene() {
        given(mockRandomGeneMixProvider.getGeneChangePosition()).willReturn(ImmutableList.of(
                new RandomGeneMixProvider.GeneChange(1, 3),
                new RandomGeneMixProvider.GeneChange(3, 0),
                new RandomGeneMixProvider.GeneChange(7, 4)
        ));
        item1.setGene("123456789");
        Item changedItem = mixGenerationItemsCreator.changeGene(item1);

        assertThat(changedItem.getGene(),is("320456489"));
    }
}
