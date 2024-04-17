package com.beaksoo.shop.comment;

import com.beaksoo.shop.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    static List<Comment> findAllByParentId(Long parentId) {
        return null;
    }

}
