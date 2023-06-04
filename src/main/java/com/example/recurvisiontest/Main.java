package com.example.recurvisiontest;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        DiscussionReplyRS d75 = new DiscussionReplyRS(155775L, null, 0L, 155774L);
        DiscussionReplyRS d76 = new DiscussionReplyRS(155776L,  null, 155775L, 155774L);
        DiscussionReplyRS d77 = new DiscussionReplyRS(155777L,  null, 155776L, 155774L);
        DiscussionReplyRS d78 = new DiscussionReplyRS(155778L,  null, 155777L, 155774L);
        DiscussionReplyRS d79 = new DiscussionReplyRS(155779L,  null, 155778L, 155774L);
        DiscussionReplyRS d80 = new DiscussionReplyRS(155780L,  null, 155779L, 155774L);
        DiscussionReplyRS d81 = new DiscussionReplyRS(155781L,  null, 155776L, 155774L);
        DiscussionReplyRS d82 = new DiscussionReplyRS(155782L,  null, 155775L, 155774L);
        DiscussionReplyRS d83 = new DiscussionReplyRS(155783L,  null, 155775L, 155774L);
        DiscussionReplyRS d84 = new DiscussionReplyRS(155784L,  null, 155775L, 155774L);
        DiscussionReplyRS d85 = new DiscussionReplyRS(155785L,  null, 155775L, 155774L);
        DiscussionReplyRS d86 = new DiscussionReplyRS(155786L,  null, 155775L, 155774L);
        DiscussionReplyRS d87 = new DiscussionReplyRS(155787L,  null, 155786L, 155774L);

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

        DiscussionReplyRS dr = new DiscussionReplyRS();

        List<DiscussionReplyRS> result = dr.mapDiscussionReplyChildThreeLevelTest(discussionHierarchy);
        result.stream().forEach((dr1) -> System.out.println(dr1.toString()));
    }
}
