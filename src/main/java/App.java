import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class App {
    public static void main(String[] args) throws JsonProcessingException {

        /*
        json 객체
        {
          "name": "lee"
        }
        json 배열
        {
          "name" : ["lee",1,2,3,45]
        }
        객체 안에 배열, 객체
        {
          "name" : [ { "name" : 1, "age": 2, 3 : 4}, 5, "ddd",],  =>>> List , ArrayList
          "ddd": "c"
        }


        json = > 실질적인 타입 in java : String ==> 이거를 Java 객체로 변환하는 걸 parsing, parse

        {
          "freeboard" : [ {"name" :1, "age": 23}, {"name" :1, "age": 23}, {"name" :1, "age": 23}, {"name" :1, "age": 23}, {"name" :1, "age": 23} ]
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode freeboardNode = mapper.readTree(json).findPath("freeboard");
        CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, FreeBoard.class);

        List<FreeBoard> freeboardList = mapper.readValue(freeboardNode.toString(), collectionType);

        System.out.println(freeboardList);

        */




        // 파싱할 json 예제
        /*
        {
            "response": {
            "code": 200
            },
            "map_id": "Savage_Main",
            "deaths": [
                {
                    "time_event": 250,
                    "is_range_valid": true,
                    "description": "QBZ"
                },
                {
                    "time_event": 562,
                    "is_range_valid": true,
                    "description": "QBZ"
                }
            ]
        }
        */
        String json = "{ \"response\" : { \"code\" : 200 }, \"map_id\" : \"Savage_Main\", \"deaths\" : [{ \"time_event\" : 250, \"is_range_valid\" : true, \"description\" : \"QBZ\" }, { \"time_event\" : 250, \"is_range_valid\" : true, \"description\" : \"QBZ\" }] }";

        ObjectMapper mapper = new ObjectMapper();

        // json to object
        GameResult gameResult = mapper.readValue(json, GameResult.class);
        System.out.println(gameResult.getResponse().getCode());
        System.out.println(gameResult.getMapid());
        System.out.println(gameResult.getDeathList().get(1));

        // json to object (with root property), 객체안에 객체가 포함되어있는 형태일때 사용
        JsonNode responseNode = mapper.readTree(json).findPath("response");

        GameResponse response = mapper.readValue(responseNode.toString(), GameResponse.class);

        System.out.println(response.getCode());

        // json to list
        JsonNode deathsNode = mapper.readTree(json).findPath("deaths");
        CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, GameDeath.class);

        List<GameDeath> gameDeathList2 = mapper.readValue(deathsNode.toString(), collectionType);

        System.out.println(gameDeathList2.get(1).getTimeEvent());


        // jackson 라이브러리는 자바 객체를 json으로 파싱할때 기본적으로 해당 객체의 getter를 기준으로 프로퍼티가 정해짐
        // 해당 클래스의 멤버변수를 따로 프로퍼티로 지정해주려면 @JsonProperty 어노테이션을 사용

        // object to json
        String objtoString = mapper.writeValueAsString(gameResult);
        System.out.println(objtoString);

    }
}