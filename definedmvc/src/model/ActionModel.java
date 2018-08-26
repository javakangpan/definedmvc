package model;

import java.util.Map;

public class ActionModel {
	private String actionName;
	private String actionClass;
	private Map<String,ResultModel> map;
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public String getActionClass() {
		return actionClass;
	}
	public void setActionClass(String actionClass) {
		this.actionClass = actionClass;
	}
	public Map<String, ResultModel> getMap() {
		return map;
	}
	public void setMap(Map<String, ResultModel> map) {
		this.map = map;
	}
}
