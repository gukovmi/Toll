package dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PointDTOTest {
    private final String autoId = "o567gfd";

    @Test
    public void toJson() throws Exception {
        PointDTO point = new PointDTO(
                autoId,
                56,
                74,
                180,
                60,
                System.currentTimeMillis());
        assertTrue(point.toJson().contains("\"lat\":56"));
        assertTrue(point.toJson().contains("\"time\":"));
        System.out.println(point.toJson());
    }

    @Test
    public void decodeDTO() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String expected = "{\"autoId\":\"o567gfd\"," +
                "\"lat\":56.0," +
                "\"lon\":74.0," +
                "\"azimuth\":180.0," +
                "\"speed\":60," +
                "\"time\":\"1605953046374\"}";
        PointDTO dto = mapper.readValue(expected, PointDTO.class);
        assertEquals(autoId, dto.getAutoId());
        assertEquals(1605953046374L, dto.getTime());
    }
}
