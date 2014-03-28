package components;

import org.fluentlenium.core.domain.FluentWebElement;

import com.google.common.base.Predicate;

public class DrawerProject {
  private final FluentWebElement element;

  public DrawerProject(FluentWebElement element) {
    this.element = element;
  }

  public String name() {
    FluentWebElement a = element.findFirst("a.name");
    if (a.isDisplayed()) {
      return a.getText().trim();
    } else {
      return element.findFirst("input").getValue().trim();
    }
  }

  public void rename(String newName) {
    element.findFirst(".name").doubleClick();
    element.findFirst("input").text(newName);
    element.click();
  }

  public Predicate isInEdit() {
    return new Predicate() {
      public boolean apply(Object o) {
        return element.findFirst("input") != null
            && element.findFirst("input").isDisplayed();
      }
    };
  }
}
