<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="db.day3.board.dao.BoardDAO">
  <insert id="insertBoard">
  	insert into board(bo_title, bo_me_id) values(#{board.bo_title},#{board.bo_me_id})
  </insert>
  <select id="selectBoardList" resultType="db.day3.board.vo.BoardVO">
  	select * from board
  </select>
  <select id="selectBoard" resultType="db.day3.board.vo.BoardVO">
  	select * from board where bo_num = #{bo_num}
  </select>
  <update id="updateBoard">
  	update board set bo_title = #{board.bo_title} where bo_num = #{board.bo_num}
  </update>
  <delete id="deleteBoard">
  	delete from board where bo_num = #{bo_num}
  </delete>
</mapper>