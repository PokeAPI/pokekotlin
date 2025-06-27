package co.pokeapi.pokekotlin.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import co.pokeapi.pokekotlin.java.PokeApi;
import io.ktor.client.plugins.ClientRequestException;
import io.ktor.http.HttpStatusCode;
import java.util.concurrent.ExecutionException;
import org.junit.Test;

public class LiveJavaTest {

  @Test
  public void resource() throws ExecutionException, InterruptedException {
    assertEquals("sitrus", PokeApi.getDefault().getBerryAsync(10).get().getName());
  }

  @Test
  public void list() throws ExecutionException, InterruptedException {
    assertEquals(
        PokeApi.getDefault().getMoveListAsync(0, 50).get().getResults().get(25),
        PokeApi.getDefault().getMoveListAsync(25, 50).get().getResults().get(0));
  }

  @Test
  public void notFound() {
    var exception =
        assertThrows(ExecutionException.class, () -> PokeApi.getDefault().getMoveAsync(-1).get());

    assertEquals(ClientRequestException.class, exception.getCause().getClass());

    var cause = (ClientRequestException) exception.getCause();
    assertEquals(HttpStatusCode.Companion.getNotFound(), cause.getResponse().getStatus());
  }
}
