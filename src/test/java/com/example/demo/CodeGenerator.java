//package com.example.demo;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.cglib.util.StringSwitcher.Generator;
//
//
//
//public class CodeGenerator {
//
//	public static void main(String[] args) {
//		List<GenParam> paramList = new ArrayList<GenParam>();
//		/**
//		 * 请保持生成参数的完整，不要注释
//		 */
//		paramList.add(new GenParam("leave", new String[] {"bpm_node"}));
//		GenConfig gc = new GenConfig();
////		gc.setBasePackage("ins.platform");
//		gc.setBasePackage("com.example");
//		// 设置要忽略的表名前缀，默认空
//		gc.setIgnoreTablePrefixs(new String[] { "prpl", "pprd" });
//		// 设置PO是否保留前缀(设置忽略表名前缀时)，默认true
//		gc.setKeepPrefixForPO(false);
//		// 设置取操作时间函数，默认空
//		gc.setOperateTimeForHisFunc("");
//		// 设置是否默认开启二级缓存（影响base中的MapperXML），默认false
//		gc.setDefaultCache(false);
//		// mysql 数据库相关配置
//		// 设置基本保存目录（Java源代码根目录） 
//		gc.setSaveDir("src/main/java"); 
//		gc.setDbDriverName("com.mysql.jdbc.Driver");
//		gc.setDbUser("root");
//		gc.setDbSchema("platform_devdb");
//		gc.setDbPassword("qk941009");
//		gc.setDbUrl("jdbc:mysql://localhost:3306/platform_devdb?characterEncoding=utf8&autoReconnect=true");
//		// 支持生成的文件类型:生成PO、BASE_MAPPER_XML（自动覆盖）、Dao、VO、MapperXML（不覆盖）
//		gc.setGenTypes(
//				new GenType[] { GenType.VO, GenType.PO, GenType.DAO, GenType.BASE_MAPPER_XML, GenType.MAPPER_XML });
//
//		Generator generator = new Generator();
//		generator.setGenConfig(gc);
//		generator.setParamList(paramList);
//		generator.generate();
//	}
//}
