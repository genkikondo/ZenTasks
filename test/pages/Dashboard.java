package pages;

import static org.fest.assertions.fluentlenium.FluentLeniumAssertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withText;

import org.fluentlenium.core.FluentPage;

import components.Drawer;

public class Dashboard extends FluentPage {
  public String getUrl() {
      return "/";
  }

  public void isAt() {
      assertThat(find("h1", withText("Dashboard"))).hasSize(1);
  }

  public Drawer drawer() {
      return Drawer.from(this);
  }
}
