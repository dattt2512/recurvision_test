package com.example.recurvisiontest;

import org.springframework.util.CollectionUtils;

import java.util.*;

public class DiscussionReplyRS {
    private Long discussionReplyId;
    private Long replyToPostId;
    private Long parentContentId;
    private List<DiscussionReplyRS> replyChildList;

    public DiscussionReplyRS() {
    }

    public DiscussionReplyRS(Long discussionReplyId, List<DiscussionReplyRS> replyChildList, Long replyToPostId, Long parentContentId) {
        this.discussionReplyId = discussionReplyId;
        this.replyToPostId = replyToPostId;
        this.parentContentId = parentContentId;
        this.replyChildList = replyChildList;
    }

    public Long getDiscussionReplyId() {
        return discussionReplyId;
    }

    public void setDiscussionReplyId(Long discussionReplyId) {
        this.discussionReplyId = discussionReplyId;
    }

    public Long getReplyToPostId() {
        return replyToPostId;
    }

    public void setReplyToPostId(Long replyToPostId) {
        this.replyToPostId = replyToPostId;
    }

    public Long getParentContentId() {
        return parentContentId;
    }

    public void setParentContentId(Long parentContentId) {
        this.parentContentId = parentContentId;
    }

    public List<DiscussionReplyRS> getReplyChildList() {
        return replyChildList;
    }

    public void setReplyChildList(List<DiscussionReplyRS> replyChildList) {
        this.replyChildList = replyChildList;
    }

    @Override
    public String toString() {
        return "{\"discussionReplyId\":" + discussionReplyId +
                ", \"replyChildList\":" + replyChildList +
                ", \"replyToPostId\":" + replyToPostId +
                ", \"parentContentId\":" + parentContentId+"}";
    }

    public List<DiscussionReplyRS> mapDiscussionReplyChildThreeLevelTest(List<DiscussionReplyRS> discussionHierarchy) {
        List<DiscussionReplyRS> result = new ArrayList<>();

        if (CollectionUtils.isEmpty(discussionHierarchy))
            return new ArrayList<>();

        Map<Long, List<DiscussionReplyRS>> discussionMapParent = new HashMap<>();

        for (DiscussionReplyRS reply : discussionHierarchy) {
            Long parentId = reply.getReplyToPostId();
            //Add 775 to result
            if (parentId == null || parentId.equals(0L)) {
                result.add(reply);
            } else {
                //children la list DiscussionReplyRS duoc lay ra tu map, co key la parentId
                //neu value hien tai la null thi tao new ArrayList, neu co gia tri roi giu nguyen va add them reply
                discussionMapParent
                        .computeIfAbsent(parentId, k -> new ArrayList<>()).add(reply);
            }
        }
        for (DiscussionReplyRS reply : result) {
            addChildrenRecursive(reply, discussionMapParent, 0);
        }
        return result;
    }

    private void addChildrenRecursive(DiscussionReplyRS parent, Map<Long, List<DiscussionReplyRS>> discussionMapParent, int level) {
        List<DiscussionReplyRS> children = discussionMapParent.get(parent.getDiscussionReplyId());
        if (children != null) {
            parent.setReplyChildList(children);
            List<DiscussionReplyRS> childrenCopy = new ArrayList<>(children);
            for (DiscussionReplyRS child : childrenCopy) {
                if (level >= 3) {
                    parent.setReplyChildList(null);
                    child.setReplyToPostId(parent.getReplyToPostId());
                    discussionMapParent
                            .computeIfAbsent(parent.getReplyToPostId(), k -> new ArrayList<>()).add(child);
                    addChildrenRecursive(child, discussionMapParent, level + 1);
                } else {
                    addChildrenRecursive(child, discussionMapParent, level + 1);
                }
            }
        }
    }
}
