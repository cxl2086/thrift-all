namespace java com.yangyang.thrift.api

service HelloService {
    string hello(1: string name);
    string baseInfo(1: string name,2:i32 age);
}