package com.tlw.jfx.treeview;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;
import javafx.util.Callback;

import com.sun.javafx.binding.ObjectConstant;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年8月18日
 */
public class B03PropertyObject extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Cat cat=new Cat();
		CatInfo catInfo=fromCat(cat);
		
		CatInfoTreeItem treeItem=new CatInfoTreeItem();
		treeItem.setValue(catInfo);
		
		TreeView<CatInfo> treeView=new TreeView<>(treeItem);
		treeView.setCellFactory(new Callback<TreeView<CatInfo>, TreeCell<CatInfo>>() {
			@Override
			public TreeCell<CatInfo> call(TreeView<CatInfo> param) {
				TreeCell<CatInfo> catInfoCell=new TreeCell<CatInfo>(){
					@Override
					protected void updateItem(CatInfo item, boolean empty) {
						super.updateItem(item, empty);
						if(item!=null && !empty){
							System.out.println("aa:"+item.name);
							setText(item.name);
						}
					}
				};
				return catInfoCell;
			}
		});
		
		Scene scene=new Scene(treeView);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static CatInfo fromCat(Cat cat) throws NoSuchMethodException{
		
		CatInfo[] insChildren=new CatInfo[cat.getIns().size()];
		for(int i=0;i<cat.getIns().size();i++){
			insChildren[i]=fromPort(cat.getIns().get(i));
		}
		
		CatInfo[] outsChildren=new CatInfo[cat.getIns().size()];
		for(int i=0;i<cat.getIns().size();i++){
			outsChildren[i]=fromPort(cat.getIns().get(i));
		}
		
		CatInfo[] gensChildren=new CatInfo[cat.getIns().size()];
		for(int i=0;i<cat.getIns().size();i++){
			gensChildren[i]=fromPort(cat.getIns().get(i));
		}
		
		CatInfo insInfo=new CatInfo();
		insInfo.name="INs";
		insInfo.children=insChildren;
		
		CatInfo outsInfo=new CatInfo();
		outsInfo.name="OUTs";
		outsInfo.children=outsChildren;
		
		CatInfo gensInfo=new CatInfo();
		gensInfo.name="GENs";
		gensInfo.children=gensChildren;
		
		CatInfo info=new CatInfo();
		info.name="Cat01";
		info.value=null;
		info.type=null;
		info.readOnly=true;
		info.leaf=false;
		info.children=new CatInfo[]{insInfo, outsInfo, gensInfo};
		
//		ObjectConstant<CatInfo> catInfoP=ObjectConstant.valueOf(info);
		
//		CatInfoTreeItem treeItem=new CatInfoTreeItem();
//		treeItem.valueProperty().addListener(new CatInfoChangeListener());
//		treeItem.addEventHandler(TreeItem.valueChangedEvent(), new EventHandler<TreeModificationEvent<CatInfo>>() {
//			@Override
//			public void handle(TreeModificationEvent<CatInfo> event) {
//				CatInfo info=event.getNewValue();
//				TreeItem<CatInfo> item=event.getSource();
//				for(CatInfo child:info.children){
//					TreeItem<CatInfo> childTreeItem=new TreeItem<CatInfo>();
//					ObjectConstant<CatInfo> catInfoX=ObjectConstant.valueOf(child);
//					childTreeItem.valueProperty().bind(catInfoX);
//					item.getChildren().add(childTreeItem);
//				}
//			}
//		});
//		treeItem.valueProperty().bind(catInfoP);
//		treeItem.setValue(info);
		
//		TreeItem<CatInfo> treeItem=new TreeItem<CatInfo>(){
//			@Override
//			public boolean isLeaf() {
//				System.out.println(getValue().leaf);
//				return getValue().leaf;
//			}
//			
//		};
		
		return info;
	}
	
	static class CatInfoTreeItem extends TreeItem<CatInfo>{
		{
			addEventHandler(TreeItem.valueChangedEvent(), new EventHandler<TreeModificationEvent<CatInfo>>() {
				@Override
				public void handle(TreeModificationEvent<CatInfo> event) {
					CatInfo info=event.getNewValue();
					TreeItem<CatInfo> item=event.getSource();
					if(info.children!=null && info.children.length>0){
						for(CatInfo child:info.children){
							CatInfoTreeItem childTreeItem=new CatInfoTreeItem();
							ObjectConstant<CatInfo> catInfoX=ObjectConstant.valueOf(child);
							childTreeItem.valueProperty().bind(catInfoX);
							item.getChildren().add(childTreeItem);
						}
					}
				}
			});
		}
		
		
		@Override
		public boolean isLeaf() {
			return getValue().leaf;
		}
			
	}
	
	static class CatInfoChangeListener implements ChangeListener<CatInfo>{
		@Override
		public void changed(ObservableValue<? extends CatInfo> observable, CatInfo oldValue, CatInfo newValue) {
			if(newValue!=null){
				for(CatInfo info:newValue.children){
					TreeItem<CatInfo> tii=new TreeItem<CatInfo>();
					tii.setValue(info);
//					System.out.println(observable.getClass());
//					observable.
//					((TreeItem)observable).getChildren().add(tii);
				}
			}
		}
	}
	
	public static CatInfo fromPort(Port port){
		CatInfo info=new CatInfo();
		info.name=port.name;
		info.value=port.getValue();
		info.type=port.getType();
		info.readOnly=false;
		info.leaf=true;
		return info;
	}
	
	public static class CatInfo{
		String name;
		Object value;
		Class<?> type;
		boolean leaf;
		boolean readOnly;
		CatInfo[] children;
		CatInfo[] getChildren(){
			return children;
		}
		@Override
		public String toString() {
			return "CatInfo [name=" + name + ", value=" + value + ", type=" + type + ", leaf=" + leaf + ", readOnly=" + readOnly + ", children=" + Arrays.toString(children) + "]";
		}
	}

	public static class Cat{
		List<Port> ins=new ArrayList<>();
		List<Port> outs=new ArrayList<>();
		List<Port> generates=new ArrayList<>();
		
		public Cat(){
			Port in0=new Port();
			in0.setType(Integer.class);
			in0.setValue(100);
			in0.setName("in0");
			ins.add(in0);
			
			Port out0=new Port();
			out0.setType(Double.class);
			out0.setValue(1.11);
			out0.setName("out0");
			outs.add(out0);
			
			Port gen0=new Port();
			gen0.setType(Double.class);
			gen0.setValue(100);
			gen0.setName("gen0");
			generates.add(gen0);
		}
		
		public List<Port> getIns() {
			return ins;
		}
		public void setIns(List<Port> ins) {
			this.ins = ins;
		}
		public List<Port> getOuts() {
			return outs;
		}
		public void setOuts(List<Port> outs) {
			this.outs = outs;
		}
		public List<Port> getGenerates() {
			return generates;
		}
		public void setGenerates(List<Port> generates) {
			this.generates = generates;
		}
	}
	
	public static class Port{
		String name;
		Class<?> type;
		Object value;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Class<?> getType() {
			return type;
		}
		public void setType(Class<?> type) {
			this.type = type;
		}
		public Object getValue() {
			return value;
		}
		public void setValue(Object value) {
			this.value = value;
		}
	}

}
