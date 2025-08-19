package com.gcorp;

import com.gcorp.data.dto.PersonDTO;
import com.gcorp.mocks.MockPerson;
import com.gcorp.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.gcorp.mapper.ObjectMapper.parseListObjects;
import static com.gcorp.mapper.ObjectMapper.parseObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectMapperTests {
    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToDTOTest() {
        PersonDTO output = parseObject(inputObject.mockEntity(), PersonDTO.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getName());
        assertEquals("Last Name Test0", output.getLastname());
        assertEquals("Address Test0", output.getAddress());
    }

    @Test
    public void parseEntityListToDTOListTest() {
        List<PersonDTO> outputList = parseListObjects(inputObject.mockEntityList(), PersonDTO.class);
        PersonDTO outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getName());
        assertEquals("Last Name Test0", outputZero.getLastname());
        assertEquals("Address Test0", outputZero.getAddress());

        PersonDTO outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getName());
        assertEquals("Last Name Test7", outputSeven.getLastname());
        assertEquals("Address Test7", outputSeven.getAddress());

        PersonDTO outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getName());
        assertEquals("Last Name Test12", outputTwelve.getLastname());
        assertEquals("Address Test12", outputTwelve.getAddress());
    }

    @Test
    public void parseDTOToEntityTest() {
        Person output = parseObject(inputObject.mockDTO(), Person.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getName());
        assertEquals("Last Name Test0", output.getLastname());
        assertEquals("Address Test0", output.getAddress());
    }

    @Test
    public void parserDTOListToEntityListTest() {
        List<Person> outputList = parseListObjects(inputObject.mockDTOList(), Person.class);
        Person outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getName());
        assertEquals("Last Name Test0", outputZero.getLastname());
        assertEquals("Address Test0", outputZero.getAddress());

        Person outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getName());
        assertEquals("Last Name Test7", outputSeven.getLastname());
        assertEquals("Address Test7", outputSeven.getAddress());

        Person outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getName());
        assertEquals("Last Name Test12", outputTwelve.getLastname());
        assertEquals("Address Test12", outputTwelve.getAddress());
    }
}
