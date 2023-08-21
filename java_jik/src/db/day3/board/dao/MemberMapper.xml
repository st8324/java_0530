<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="db.day3.board.dao.MemberDAO">
  <select id="selectMember" resultType="db.day3.board.vo.MemberVO">
  	select * from member where me_id = #{me_id}
  </select>
  <insert id="insertMember">
  	insert into member(me_id, me_pw) values(#{member.me_id},#{member.me_pw})
  </insert>
  <insert id="insertMember2">
  	insert into member(me_id, me_pw) values(#{me_id},#{me_pw})
  </insert>
  <delete id="deleteMember">
  	delete from member where me_id = #{me_id}
  </delete>
  <update id="updateBoardCount">
  	update member set me_board_count = me_board_count + 1 where me_id = #{me_id}
  </update>

</mapper>