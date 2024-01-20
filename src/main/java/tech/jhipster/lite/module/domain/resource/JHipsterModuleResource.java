package tech.jhipster.lite.module.domain.resource;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import tech.jhipster.lite.module.domain.JHipsterModuleFactory;
import tech.jhipster.lite.module.domain.JHipsterModuleSlug;
import tech.jhipster.lite.shared.error.domain.Assert;

public final class JHipsterModuleResource {

  private final JHipsterModuleSlug slug;
  private final JHipsterModulePropertiesDefinition propertiesDefinition;
  private final JHipsterModuleApiDoc apiDoc;
  private final JHipsterModuleOrganization organization;
  private final JHipsterModuleTags tags;
  private final JHipsterModuleFactory factory;

  private JHipsterModuleResource(JHipsterModuleResourceBuilder builder) {
    assertMandatoryFields(builder);

    slug = builder.slug.build();
    propertiesDefinition = builder.propertiesDefinition;
    apiDoc = builder.apiDoc;
    tags = builder.tags;
    organization = builder.organization;
    factory = builder.factory;
  }

  private void assertMandatoryFields(JHipsterModuleResourceBuilder builder) {
    Assert.notNull("slug", builder.slug);
    Assert.notNull("propertiesDefinition", builder.propertiesDefinition);
    Assert.notNull("apiDoc", builder.apiDoc);
    Assert.notNull("tags", builder.tags);
    Assert.notNull("organization", builder.organization);
    Assert.notNull("factory", builder.factory);
  }

  public static JHipsterModuleResourceSlugBuilder builder() {
    return new JHipsterModuleResourceBuilder();
  }

  public String moduleUrl() {
    return "/api/modules/" + slug.get();
  }

  public JHipsterModuleSlug slug() {
    return slug;
  }

  public JHipsterModuleApiDoc apiDoc() {
    return apiDoc;
  }

  public JHipsterModuleTags tags() {
    return tags;
  }

  public JHipsterModuleOrganization organization() {
    return organization;
  }

  public JHipsterModuleFactory factory() {
    return factory;
  }

  public JHipsterModulePropertiesDefinition propertiesDefinition() {
    return propertiesDefinition;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
      .append("slug", slug)
      .append("apiDoc", apiDoc)
      .append("tags", tags)
      .append("organization", organization)
      .append("propertiesDefinition", propertiesDefinition)
      .build();
  }

  private static final class JHipsterModuleResourceBuilder
    implements
      JHipsterModuleResourceSlugBuilder,
      JHipsterModuleResourcePropertiesDefinitionBuilder,
      JHipsterModuleResourceApiDocBuilder,
      JHipsterModuleResourceOrganizationBuilder,
      JHipsterModuleResourceTagsBuilder,
      JHipsterModuleResourceFactoryBuilder {

    private JHipsterModuleSlugFactory slug;
    private JHipsterModuleApiDoc apiDoc;
    private JHipsterModuleFactory factory;
    private JHipsterModulePropertiesDefinition propertiesDefinition;

    private JHipsterModuleTags tags;
    private JHipsterModuleOrganization organization;

    @Override
    public JHipsterModuleResourcePropertiesDefinitionBuilder slug(JHipsterModuleSlugFactory slug) {
      this.slug = slug;

      return this;
    }

    @Override
    public JHipsterModuleResourceApiDocBuilder propertiesDefinition(JHipsterModulePropertiesDefinition propertiesDefinition) {
      this.propertiesDefinition = propertiesDefinition;

      return this;
    }

    @Override
    public JHipsterModuleResourceOrganizationBuilder apiDoc(JHipsterModuleApiDoc apiDoc) {
      this.apiDoc = apiDoc;

      return this;
    }

    @Override
    public JHipsterModuleResourceTagsBuilder organization(JHipsterModuleOrganization organization) {
      this.organization = organization;

      return this;
    }

    @Override
    public JHipsterModuleResourceFactoryBuilder tags(JHipsterModuleTags tags) {
      this.tags = tags;

      return this;
    }

    @Override
    public JHipsterModuleResource factory(JHipsterModuleFactory factory) {
      this.factory = factory;

      return new JHipsterModuleResource(this);
    }
  }

  public interface JHipsterModuleResourceSlugBuilder {
    JHipsterModuleResourcePropertiesDefinitionBuilder slug(JHipsterModuleSlugFactory slug);
  }

  public interface JHipsterModuleResourcePropertiesDefinitionBuilder {
    JHipsterModuleResourceApiDocBuilder propertiesDefinition(JHipsterModulePropertiesDefinition propertiesDefinition);

    default JHipsterModuleResourceApiDocBuilder withoutProperties() {
      return propertiesDefinition(JHipsterModulePropertiesDefinition.EMPTY);
    }
  }

  public interface JHipsterModuleResourceApiDocBuilder {
    JHipsterModuleResourceOrganizationBuilder apiDoc(JHipsterModuleApiDoc apiDoc);

    default JHipsterModuleResourceOrganizationBuilder apiDoc(String group, String operation) {
      return apiDoc(new JHipsterModuleApiDoc(group, operation));
    }
  }

  public interface JHipsterModuleResourceOrganizationBuilder {
    JHipsterModuleResourceTagsBuilder organization(JHipsterModuleOrganization organization);

    default JHipsterModuleResourceTagsBuilder standalone() {
      return organization(JHipsterModuleOrganization.STANDALONE);
    }
  }

  public interface JHipsterModuleResourceTagsBuilder {
    JHipsterModuleResourceFactoryBuilder tags(JHipsterModuleTags tags);

    default JHipsterModuleResourceFactoryBuilder tags(String... tags) {
      return tags(JHipsterModuleTags.builder().add(tags).build());
    }
  }

  public interface JHipsterModuleResourceFactoryBuilder {
    JHipsterModuleResource factory(JHipsterModuleFactory factory);
  }
}
