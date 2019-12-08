班级：计G191 
姓名 : 李媛媛 
学号：2019322026  
# JAVA实验报告五--学生选课系统  
## 一、实验目的:  
1.使用GUI窗体及其组件设计窗体界面  
2.完成学生选课过程业务逻辑编程  
3.基于文件保存并读取数据  
4.处理异常  
## 二、实验要求 
1.设计GUI窗体，支持学生注册、课程新加、学生选课、学生退课、打印学生选课列表等操作  
2.基于事件模型对业务逻辑编程，实现在界面上支持上述操作  
3.针对操作过程中可能会出现的各种异常，做异常处理  
4.基于输入/输出编程，支持学生、课程、教师等数据的读写操作  
## 三、实验过程  
1.在选课系统的基础上添加GUI窗体  
2.实现选课退课数据的基本文件输出和输入
### 核心代码： 
添加点击事件  
~~~
  jbOk.addActionListener(new ActionListener() {             
            public void actionPerformed(ActionEvent e) {  
                StringBuilder info=new StringBuilder();  
                String name=jtfName.getText();  
                String num=jtfNum.getText();  
                String sex;  
~~~
      jbRest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jtfName.setText("");
                jtfNum.setText("");
                jrb1.setSelected(true);
                jcb1.setSelected(false);
                t1.setSelectedIndex(0);
                jcb2.setSelected(false);
                t2.setSelectedIndex(0);
                massage.setText("");
            }
~~~
判断并打印
~~~
                if(jrb1.isSelected()){
                    sex="男";
                }else {
                    sex="女";
                }
                info.append("姓名："+name+"\n学号："+num+"\n性别："+sex+"\n所选课程:");
                if(jcb1.isSelected()){
                    String c=jcb1.getText();
                    String t=t1.getSelectedItem().toString();
                    info.append(c+"\n授课老师:"+t);
                }
                if(jcb2.isSelected()){
                    String c=jcb2.getText();
                    String t=t2.getSelectedItem().toString();
                    info.append(""+c+"\n授课老师:"+t);
                }
                if(jcb3.isSelected()){
                    String c=jcb3.getText();
                    String t=t3.getSelectedItem().toString();
                    info.append(""+c+"\n授课老师:"+t);
                }
                massage.setText(info.toString());                               
            }
        });
        ~~~
异常处理
~~~
public void actionPerformed(ActionEvent e) {
		File file = new File("d:\\Text.txt");  
        try {  
            file.createNewFile();  
        } catch (IOException e1) {  
            e1.printStackTrace();  
        }  
~~~
运行截图：

## 四、实验心得
  本学期我们进行了五次Java 实验，经过这五次实验，我深切体会到投身实践的重要性。在本次实验中综合性的归纳了以往学过的知识点，整合已学知识编写本次实验程序。通过本次实验，我系统的再次了解和应用gui框体、事件监听、异常处理、文件保存与读取的逻辑编程。在本次实验的过程中，我认识到自己在实践中的不足，缺乏相应的知识与经验，对所学专业知识不能够很好的应用。所以在同班同学们的帮助下，熟悉并完成了代码编写，同时让我对程序设计有了成就感与兴趣感。希望通过这段时间的学习，能给以后的工作奠定坚持的基础。
