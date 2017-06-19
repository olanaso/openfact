package org.openfact.component;

import org.openfact.models.OrganizationModel;
import org.openfact.provider.ConfiguredProvider;
import org.openfact.provider.ProviderConfigProperty;
import org.openfact.provider.ProviderFactory;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface ComponentFactory<CreatedType, ProviderType> extends ProviderFactory<ProviderType>, ConfiguredProvider {

    CreatedType create(OrganizationModel organization, ComponentModel model);

    @Override
    default ProviderType create() {
        return null;
    }

    default void validateConfiguration(OrganizationModel organization, ComponentModel model) throws ComponentValidationException {
    }

    default void onCreate(OrganizationModel organization, ComponentModel model) {
    }


    default void onUpdate(OrganizationModel organization, ComponentModel model) {
    }

    /**
     * These are config properties that are common across all implementation of this component type
     *
     * @return
     */
    default List<ProviderConfigProperty> getCommonProviderConfigProperties() {
        return Collections.EMPTY_LIST;
    }

    /**
     * This is metadata about this component type.  Its really configuration information about the component type and not
     * an individual instance
     *
     * @return
     */
    default Map<String, Object> getTypeMetadata() {
        return Collections.EMPTY_MAP;
    }


}
