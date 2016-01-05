package com.ecetech.b3.projetit.beans;

public class Comment {
	
	/**
	 * Attributes
	 */
	private int idComment;
	private String contentComment;
	private int idParticipate;
	
	/**
	 * 
	 * @return The id of a Comment
	 */
	public int getIdComment() {
		return idComment;
	}
	/**
	 * 
	 * @param idComment The id of a Comment
	 */
	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}
	/**
	 * 
	 * @return The content of a Comment
	 */
	public String getContentComment() {
		return contentComment;
	}
	/**
	 * 
	 * @param contentComment The content of a Comment
	 */
	public void setContentComment(String contentComment) {
		this.contentComment = contentComment;
	}
	/**
	 * 
	 * @return The id of the couple User/Event the Comment refer to
	 */
	public int getIdParticipate() {
		return idParticipate;
	}
	/**
	 * 
	 * @param idParticipate The id of the couple User/Event the Comment refer to
	 */
	public void setIdParticipate(int idParticipate) {
		this.idParticipate = idParticipate;
	}
	
	/**
	 * Constructor
	 * @param idComment
	 * 			The id of a Comment
	 * @param contentComment
	 * 			The content of a Comment
	 * @param idParticipate
	 * 			The id of the couple User/Event the Comment refer to
	 */
	public Comment(int idComment, String contentComment, int idParticipate) {
		super();
		this.idComment = idComment;
		this.contentComment = contentComment;
		this.idParticipate = idParticipate;
	}
	/**
	 * Constructor null
	 */
	public Comment() {
		this(0, null, 0);
	}
	
	/**
	 * Display the attributes of a Comment
	 */
	public void display() {
		System.out.println("idComment: " + this.idComment + ", idParticipate: " + this.idParticipate + ", contentComment: " + this.contentComment);
	}

}
