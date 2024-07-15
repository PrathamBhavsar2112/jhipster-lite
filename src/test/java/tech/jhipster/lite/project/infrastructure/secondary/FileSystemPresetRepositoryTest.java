package tech.jhipster.lite.project.infrastructure.secondary;

import static org.assertj.core.api.Assertions.*;

import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Test;
import tech.jhipster.lite.UnitTest;
import tech.jhipster.lite.project.domain.ModuleSlug;
import tech.jhipster.lite.project.domain.preset.Preset;
import tech.jhipster.lite.project.domain.preset.PresetName;

@UnitTest
class FileSystemPresetRepositoryTest {

  @Test
  void shouldGetExistingPreset() {
    FileSystemPresetRepository presetRepository = new FileSystemPresetRepository();

    Collection<Preset> presets = presetRepository.get("src/test/resources/projects/preset/preset.json");

    Preset expectedPreset = new Preset(
      new PresetName("angular + spring boot"),
      List.of(
        new ModuleSlug("init"),
        new ModuleSlug("application-service-hexagonal-architecture-documentation"),
        new ModuleSlug("maven-java"),
        new ModuleSlug("prettier"),
        new ModuleSlug("angular-core"),
        new ModuleSlug("java-base"),
        new ModuleSlug("maven-wrapper"),
        new ModuleSlug("spring-boot"),
        new ModuleSlug("spring-boot-mvc-empty"),
        new ModuleSlug("logs-spy"),
        new ModuleSlug("spring-boot-tomcat")
      )
    );
    assertThat(presets).containsExactly(expectedPreset);
  }
}
