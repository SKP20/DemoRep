package learningXML;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.Object;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
// --- <<IS-END-IMPORTS>> ---

public final class javaServices

{
	// ---( internal utility methods )---

	final static javaServices _instance = new javaServices();

	static javaServices _newInstance() { return new javaServices(); }

	static javaServices _cast(Object o) { return (javaServices)o; }

	// ---( server methods )---




	public static final void writeToFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(writeToFile)>> ---
		// @sigtype java 3.5
		// [i] field:0:required ff_doc
		// [o] field:0:required Status
		// [o] field:0:required status1
		// input
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	ff_doc = IDataUtil.getString( pipelineCursor, "ff_doc" );
		pipelineCursor.destroy();
		
		// pipeline
		
		
		
		// output
		IData 	output = IDataFactory.create();
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		try{
			RandomAccessFile stream = new RandomAccessFile("C:\\Users\\sauk\\Documents\\myXMLfile\\stringToFile.txt", "rw");
			long len = stream.length();
			//System.out.println(len);
		    FileChannel channel = stream.getChannel();
		    byte[] strBytes = ff_doc.getBytes();
		    int size=strBytes.length;
		    size+=4;
		    ByteBuffer buffer = ByteBuffer.allocate(size);
		    //stream.writeBytes("\r\n");
		    buffer.put(System.lineSeparator().getBytes());
		   // buffer.put(System.lineSeparator().toString());
		    buffer.put(strBytes);
		    buffer.flip();
		    
		    channel.write(buffer,len);
		    
		    stream.close();
		    channel.close();
		    
		   
			
			IDataUtil.put( pipelineCursor_1, "Status", len );
			pipelineCursor_1.destroy();
			
		}catch( Exception e){
			long len1=0;
			IDataUtil.put( pipelineCursor_1, "Status1", len1 );
		}
		
			
		// --- <<IS-END>> ---

                
	}
}

