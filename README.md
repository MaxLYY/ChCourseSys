班级：计G191 
姓名 : 李媛媛 
学号：2019322026  
# JAVA实验报告五--学生选课系统  
## 实验目的:  
1.使用GUI窗体及其组件设计窗体界面  
2.完成学生选课过程业务逻辑编程  
3.基于文件保存并读取数据  
4.处理异常  
## 实验要求 
1.设计GUI窗体，支持学生注册、课程新加、学生选课、学生退课、打印学生选课列表等操作。
2.基于事件模型对业务逻辑编程，实现在界面上支持上述操作。
3.针对操作过程中可能会出现的各种异常，做异常处理
4.基于输入/输出编程，支持学生、课程、教师等数据的读写操作。
## 实验过程  
1.在选课系统的基础上添加GUI窗体
2.实现选课退课数据的基本文件输出和输入
### 实验流程图：




### 核心代码：
  public void actionPerformed(ActionEvent e) {
                StringBuilder info=new StringBuilder();
                String name=jtfName.getText();
                String num=jtfNum.getText();
                String sex;
                if(jrb1.isSelected()){
                    sex="男";
                }else {
                    sex="女";
                }
                info.append(name+num+sex);
                if(jcb1.isSelected()){
                    String c=jcb1.getText();
                    String t=t1.getSelectedItem().toString();
                    info.append(":"+c+t);
                }
                if(jcb2.isSelected()){
                    String c=jcb2.getText();
                    String t=t2.getSelectedItem().toString();
                    info.append(","+c+t);
                }
                if(jcb3.isSelected()){
                    String c=jcb3.getText();
                    String t=t3.getSelectedItem().toString();
                    info.append(","+c+t);
                }
                massage.setText(info.toString());                               
            }
        });
public void actionPerformed(ActionEvent e) {
		File file = new File("d:\\Text.txt");  
        try {  
            file.createNewFile();  
        } catch (IOException e1) {  
            e1.printStackTrace();  
        }  
  
        String str = massage.getText();  
        byte bt[] = new byte[1024];  
        bt = str.getBytes();  
        try {  
            FileOutputStream in = new FileOutputStream(file);  
            try {  
                in.write(bt, 0, bt.length);  
                in.close();  
            } catch (IOException e1) {  
                e1.printStackTrace();  
            }  
        } catch (FileNotFoundException e1) {  
            e1.printStackTrace();  
        }  
        try {  
            FileInputStream out = new FileInputStream(file);  
            InputStreamReader isr = new InputStreamReader(out);  
            int ch = 0;  
            while ((ch = isr.read()) != -1) {  
                System.out.print((char) ch);  
            }  
        } catch (Exception e1) {  
        }  
    }  







运行截图：











编程感想：
