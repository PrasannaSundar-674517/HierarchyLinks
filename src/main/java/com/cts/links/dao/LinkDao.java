package com.cts.links.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cts.links.pojo.Link;
import com.cts.links.pojo.Page;

import ch.qos.logback.core.net.SyslogOutputStream;

@PropertySource(value = "classpath:application.properties")
@Component
public class LinkDao {

	private static final Logger log = Logger.getLogger(LinkDao.class);
	@Autowired
	JdbcTemplate jdbc;
	@Value("${page.a.query}")
	private String sqla;
	@Value("${page.b.query}")
	private String sqlb;
	@Value("${page.c.query}")
	private String sqlc;
	@Value("${page.d.query}")
	private String sqld;

	public List<Link> getLinks(String linkName) { // Hierarchial data model

		List<Link> links = new ArrayList<Link>();
		String sql = "select link_id,link_name,parent_link_id from link_mapping where parent_link_id = (select link_id from link_mapping where link_name= "
				+ "'" + linkName + "'" + " )";
		return links = jdbc.query(sql, new BeanPropertyRowMapper<Link>(Link.class));
	}

	public List<Page> getSubLinks(String linkName,String tableName){
		
		List<Page> links = null;
		
		try{
			/* sql = "select Page_"+tableName+"_Id,Page__"+tableName+"Name from page"+tableName+" where parent_link_id = (select link_id from link_mapping where link_name= "
						+ "'" + linkName + "'" + " )";
		}*/
			if(tableName.equals("A")){
				System.out.println("Table A executed");
				System.out.println(sqla);
			
			return links = jdbc.query(sqla, new BeanPropertyRowMapper<Page>(Page.class));
			}
			else if(tableName.equals("B")){
		
				System.out.println("Table B executed");
				System.out.println(sqlb);
				sqlb = sqlb+"'"+linkName+"'"+")";
				System.out.println(sqlb);
				return links = jdbc.query(sqlb, new BeanPropertyRowMapper<Page>(Page.class));
			}
			else if(tableName.equals("C")){
				
				System.out.println("Table C executed");
				sqlc = sqlc+"'"+linkName+"'"+")";	
				return links = jdbc.query(sqlc, new BeanPropertyRowMapper<Page>(Page.class));
			}
			else if(tableName.equals("D")){
				
				System.out.println("Table D executed");
				sqld = sqld+"'"+linkName+"'"+")";
				return links = jdbc.query(sqld, new BeanPropertyRowMapper<Page>(Page.class));
			}
			else 
				return null;
			
			
		}
					
					
		catch(Exception e){
			
		}
		return null;
		
	}

}
