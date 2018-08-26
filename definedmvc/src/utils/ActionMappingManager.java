package utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import model.ActionModel;
import model.ResultModel;

public class ActionMappingManager {
	private HashMap<String,ActionModel> actionModelMap = new HashMap<String,ActionModel>();

	@SuppressWarnings("unchecked")
	public void init() {

		try {
			String path = ActionModel.class.getResource("/struts.xml").getPath();
			File file = new File(path);
			SAXReader reader = new SAXReader();
			Document doc = reader.read(file);
			Element root = doc.getRootElement();
					
			List<Element> list = root.elements();
			
			
			for(Element ele : list) {
				
				ActionModel actionModel = new ActionModel();
				String actionName = ele.attributeValue("name");
				String actionClass = ele.attributeValue("class");
				actionModel.setActionName(actionName);
				actionModel.setActionClass(actionClass);
				
				Map<String,ResultModel> resultModelMap = new HashMap<String,ResultModel>();
				List<Element> results = ele.elements();
				for(Element eles : results) {
					
					String resultName = eles.attributeValue("name");
					String resultPath = eles.getTextTrim();
					ResultModel resultModel = new ResultModel();
					resultModel.setResultPath(resultPath);
					resultModel.setResultName(resultName);
					resultModelMap.put(resultName, resultModel);
				}
			
				actionModel.setMap(resultModelMap);
				actionModelMap.put(actionName,actionModel);
			}
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
	}
	public ActionModel getActionModel(String key) {
		return actionModelMap.get(key);
	}
}
