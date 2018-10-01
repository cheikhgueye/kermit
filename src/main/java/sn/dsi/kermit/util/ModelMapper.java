package sn.dsi.kermit.util;


import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import sn.dsi.kermit.model.Structure;
import sn.dsi.kermit.model.User;
import sn.dsi.kermit.payload.StructureResponse;
import sn.dsi.kermit.payload.UserSummary;

public class ModelMapper {

    public static StructureResponse mapPollToPollResponse(Structure structure, Map<Long, Long> choiceVotesMap, User creator, Long userVote) {
        StructureResponse structureResponse = new  StructureResponse();
        structureResponse .setId(structure.getId());
        structureResponse .setCode_structure(structure.getCode_structure());
        structureResponse .setType(structure.getType());

        return  structureResponse ;
    }

}
