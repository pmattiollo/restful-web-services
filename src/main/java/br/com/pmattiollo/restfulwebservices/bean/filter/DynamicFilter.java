package br.com.pmattiollo.restfulwebservices.bean.filter;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;

public class DynamicFilter {

    private MappingJacksonValue mappingJacksonValue;
    private String filterName;

    private DynamicFilter(MappingJacksonValue mappingJacksonValue, String filterName) {
        this.mappingJacksonValue = mappingJacksonValue;
        this.filterName = filterName;
    }

    public static DynamicFilter oneFilter(Object bean, String filterName) {
        MappingJacksonValue mapping = new MappingJacksonValue(bean);
        return new DynamicFilter(mapping, filterName);
    }

    public DynamicFilter exposeOnly(String... fields) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
        mappingJacksonValue.setFilters(getFilterProvider(filter));
        return this;
    }

    private FilterProvider getFilterProvider(SimpleBeanPropertyFilter filter) {
        return new SimpleFilterProvider().addFilter(filterName, filter);
    }

    public MappingJacksonValue get() {
        return mappingJacksonValue;
    }

}
