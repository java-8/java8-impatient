/**
 * 
 */
package study.java8.fp;

import java.io.File;
import java.io.FileFilter;

/**
 * @author jack
 *
 */
public class SFileFilter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SFileFilter fpStyle = new SFileFilter();
		File[] f1 = fpStyle.listHiddenFiles1(".");
		File[] f2 = fpStyle.listHiddenFiles2(".");

		for (File f : f1) {
			System.out.println(f.getAbsolutePath());
		}

		for (File f : f2) {
			System.out.println(f.getAbsolutePath());
		}

	}

	/**
	 * 筛选隐藏文件
	 * 
	 * @param path
	 * @return
	 */
	File[] listHiddenFiles1(String path) {
		return new File(path).listFiles(new FileFilter() {

			@Override
			public boolean accept(File f) {
				return f.isHidden();
			}
		});

	}

	/**
	 * 筛选隐藏文件
	 * 
	 * @param path
	 * @return
	 */
	File[] listHiddenFiles2(String path) {
		return new File(path).listFiles(File::isHidden);
	}

}
