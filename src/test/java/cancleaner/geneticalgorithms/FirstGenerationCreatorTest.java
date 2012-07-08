package cancleaner.geneticalgorithms;

import cancleaner.io.LogWriter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

public class FirstGenerationCreatorTest {

    private FirstGenerationCreator firstGenerationCreator;
    private List<Item> items;
    private LogWriter mockLogWriter;

    @Before
    public void setUp() {
        firstGenerationCreator = new FirstGenerationCreator();
        mockLogWriter = Mockito.mock(LogWriter.class);
        firstGenerationCreator.setLogWriter(mockLogWriter);
    }

    @Test
    public void should_create_200_items() {
        items = firstGenerationCreator.create();

        assertThat(items.size(), is(200));
    }

    @Test
    public void should_create_items_with_generation_id() {
        items = firstGenerationCreator.create();

        for (Item item : items) {
            assertThat(item.getGenerationId(), is(1));
        }
    }

    @Test
    public void should_create_items_with_sequence_id() {
        items = firstGenerationCreator.create();

        assertThat(items.get(0).getId(), is(1));
        assertThat(items.get(199).getId(), is(200));
    }

    @Test
    public void should_create_items_with_gene() {
        items = firstGenerationCreator.create();

        for (Item item : items) {
            assertThat(item.getGene().length(), is(3 * 3 * 3 * 3 * 3));
        }
    }

    @Test
    public void should_create_items_with_gene_between_0_and_5() {
        items = firstGenerationCreator.create();

        for (Item item : items) {
            for (int i = 0; i < item.getGene().length(); i++) {
                assertThat(Integer.valueOf(String.valueOf(item.getGene().charAt(i))), greaterThanOrEqualTo(0));
                assertThat(Integer.valueOf(String.valueOf(item.getGene().charAt(i))), lessThanOrEqualTo(5));
            }
        }
    }

    @Test
    public void should_write_items_to_file() {
        LogWriter mockLogWriter = Mockito.mock(LogWriter.class);
        firstGenerationCreator.setLogWriter(mockLogWriter);

        items = firstGenerationCreator.create();

        verify(mockLogWriter).write(eq("generation_1"), anyString());
    }
}
