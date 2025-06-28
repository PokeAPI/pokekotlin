package co.pokeapi.pokekotlin.test;

import co.pokeapi.pokekotlin.PokeApi;
import io.ktor.client.plugins.ClientRequestException;
import io.ktor.http.HttpStatusCode;
import java.util.concurrent.ExecutionException;
import org.junit.Assert;
import org.junit.Test;

public class LiveJavaTest {

  @Test
  public void resource() throws ExecutionException, InterruptedException {
    Assert.assertEquals("sitrus", PokeApi.Default.getBerryAsync(10).get().getName());
  }

  @Test
  public void list() throws ExecutionException, InterruptedException {
    Assert.assertEquals(
        PokeApi.Default.getBerryListAsync(0, 10).get().getResults().get(5),
        PokeApi.Default.getBerryListAsync(5, 15).get().getResults().get(0));
  }

  @Test
  public void notFound() {
    var exception =
        Assert.assertThrows(ExecutionException.class, () -> PokeApi.Default.getMoveAsync(-1).get());

    Assert.assertEquals(ClientRequestException.class, exception.getCause().getClass());

    var cause = (ClientRequestException) exception.getCause();
    Assert.assertEquals(HttpStatusCode.Companion.getNotFound(), cause.getResponse().getStatus());
  }
}
