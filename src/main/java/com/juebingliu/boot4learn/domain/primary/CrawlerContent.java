package com.juebingliu.boot4learn.domain.primary;

public class CrawlerContent {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crawler_content.id
     *
     * @mbggenerated Wed Jun 05 14:17:46 CST 2019
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crawler_content.publish_time
     *
     * @mbggenerated Wed Jun 05 14:17:46 CST 2019
     */
    private String publishTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crawler_content.publish_content
     *
     * @mbggenerated Wed Jun 05 14:17:46 CST 2019
     */
    private String publishContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crawler_content.crawler_date
     *
     * @mbggenerated Wed Jun 05 14:17:46 CST 2019
     */
    private String crawlerDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crawler_content.crawler_time
     *
     * @mbggenerated Wed Jun 05 14:17:46 CST 2019
     */
    private String crawlerTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crawler_content.id
     *
     * @return the value of crawler_content.id
     *
     * @mbggenerated Wed Jun 05 14:17:46 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crawler_content.id
     *
     * @param id the value for crawler_content.id
     *
     * @mbggenerated Wed Jun 05 14:17:46 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crawler_content.publish_time
     *
     * @return the value of crawler_content.publish_time
     *
     * @mbggenerated Wed Jun 05 14:17:46 CST 2019
     */
    public String getPublishTime() {
        return publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crawler_content.publish_time
     *
     * @param publishTime the value for crawler_content.publish_time
     *
     * @mbggenerated Wed Jun 05 14:17:46 CST 2019
     */
    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime == null ? null : publishTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crawler_content.publish_content
     *
     * @return the value of crawler_content.publish_content
     *
     * @mbggenerated Wed Jun 05 14:17:46 CST 2019
     */
    public String getPublishContent() {
        return publishContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crawler_content.publish_content
     *
     * @param publishContent the value for crawler_content.publish_content
     *
     * @mbggenerated Wed Jun 05 14:17:46 CST 2019
     */
    public void setPublishContent(String publishContent) {
        this.publishContent = publishContent == null ? null : publishContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crawler_content.crawler_date
     *
     * @return the value of crawler_content.crawler_date
     *
     * @mbggenerated Wed Jun 05 14:17:46 CST 2019
     */
    public String getCrawlerDate() {
        return crawlerDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crawler_content.crawler_date
     *
     * @param crawlerDate the value for crawler_content.crawler_date
     *
     * @mbggenerated Wed Jun 05 14:17:46 CST 2019
     */
    public void setCrawlerDate(String crawlerDate) {
        this.crawlerDate = crawlerDate == null ? null : crawlerDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crawler_content.crawler_time
     *
     * @return the value of crawler_content.crawler_time
     *
     * @mbggenerated Wed Jun 05 14:17:46 CST 2019
     */
    public String getCrawlerTime() {
        return crawlerTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crawler_content.crawler_time
     *
     * @param crawlerTime the value for crawler_content.crawler_time
     *
     * @mbggenerated Wed Jun 05 14:17:46 CST 2019
     */
    public void setCrawlerTime(String crawlerTime) {
        this.crawlerTime = crawlerTime == null ? null : crawlerTime.trim();
    }
}