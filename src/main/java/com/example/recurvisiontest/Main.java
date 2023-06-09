package com.example.recurvisiontest;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    /*
    75
    |--76
        |--81
        |--77
            |--78
                |--79
                    |--80
                        |--88
                            |--93
                                |--94
                            |--89
                                |--90
                                    |--95
                                    |--91
                                        |--96
                                        |--92
    |--82
    |--83
    |--84
    |--85
    |--86
        |--87
     */

    public static void main(String[] args) {
        DiscussionReplyRS d75 = new DiscussionReplyRS(155775L, null, 0L, 155774L);
        DiscussionReplyRS d76 = new DiscussionReplyRS(155776L,  null, 155775L, 155774L);
        DiscussionReplyRS d77 = new DiscussionReplyRS(155777L,  null, 155776L, 155774L);
        DiscussionReplyRS d78 = new DiscussionReplyRS(155778L,  null, 155777L, 155774L);
        DiscussionReplyRS d79 = new DiscussionReplyRS(155779L,  null, 155778L, 155774L);
        DiscussionReplyRS d80 = new DiscussionReplyRS(155780L,  null, 155779L, 155774L);
        DiscussionReplyRS d88 = new DiscussionReplyRS(155788L,  null, 155780L, 155774L);
        DiscussionReplyRS d89 = new DiscussionReplyRS(155789L,  null, 155788L, 155774L);
        DiscussionReplyRS d90 = new DiscussionReplyRS(155790L,  null, 155789L, 155774L);
        DiscussionReplyRS d91 = new DiscussionReplyRS(155791L,  null, 155790L, 155774L);
        DiscussionReplyRS d92 = new DiscussionReplyRS(155792L,  null, 155791L, 155774L);
        DiscussionReplyRS d81 = new DiscussionReplyRS(155781L,  null, 155776L, 155774L);
        DiscussionReplyRS d82 = new DiscussionReplyRS(155782L,  null, 155775L, 155774L);
        DiscussionReplyRS d83 = new DiscussionReplyRS(155783L,  null, 155775L, 155774L);
        DiscussionReplyRS d84 = new DiscussionReplyRS(155784L,  null, 155775L, 155774L);
        DiscussionReplyRS d85 = new DiscussionReplyRS(155785L,  null, 155775L, 155774L);
        DiscussionReplyRS d86 = new DiscussionReplyRS(155786L,  null, 155775L, 155774L);
        DiscussionReplyRS d87 = new DiscussionReplyRS(155787L,  null, 155786L, 155774L);
        DiscussionReplyRS d93 = new DiscussionReplyRS(155793L,  null, 155788L, 155774L);
        DiscussionReplyRS d94 = new DiscussionReplyRS(155794L,  null, 155793L, 155774L);
        DiscussionReplyRS d95 = new DiscussionReplyRS(155795L,  null, 155790L, 155774L);
        DiscussionReplyRS d96 = new DiscussionReplyRS(155796L,  null, 155791L, 155774L);

        List<DiscussionReplyRS> discussionHierarchy = new ArrayList<>();
        discussionHierarchy.add(d75);
        discussionHierarchy.add(d76);
        discussionHierarchy.add(d77);
        discussionHierarchy.add(d78);
        discussionHierarchy.add(d79);
        discussionHierarchy.add(d80);
        discussionHierarchy.add(d81);
        discussionHierarchy.add(d82);
        discussionHierarchy.add(d83);
        discussionHierarchy.add(d84);
        discussionHierarchy.add(d85);
        discussionHierarchy.add(d86);
        discussionHierarchy.add(d87);
        discussionHierarchy.add(d88);
        discussionHierarchy.add(d89);
        discussionHierarchy.add(d90);
        discussionHierarchy.add(d91);
        discussionHierarchy.add(d92);
        discussionHierarchy.add(d93);
        discussionHierarchy.add(d94);
        discussionHierarchy.add(d95);
        discussionHierarchy.add(d96);

        DiscussionReplyRS dr = new DiscussionReplyRS();

        List<DiscussionReplyRS> result = dr.mapDiscussionReplyChildThreeLevelTest(discussionHierarchy);
        result.stream().forEach((dr1) -> System.out.println(dr1.toString()));
    }
}
